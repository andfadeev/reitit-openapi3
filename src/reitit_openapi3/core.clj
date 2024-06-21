(ns reitit-openapi3.core
  (:gen-class)
  (:require [reitit.ring :as ring]
            [ring.adapter.jetty :as jetty]
            [reitit.coercion.malli]
            [reitit.openapi :as openapi]
            [reitit.ring.malli]
            [reitit.swagger :as swagger]
            [reitit.swagger-ui :as swagger-ui]
            [reitit.ring.coercion :as coercion]
            [reitit.dev.pretty :as pretty]
            [reitit.ring.middleware.muuntaja :as muuntaja]
            [reitit.ring.middleware.exception :as exception]
            [reitit.ring.middleware.multipart :as multipart]
            [reitit.ring.middleware.parameters :as parameters]
            [reitit.ring.spec :as spec]
            [muuntaja.core :as m]
            [malli.util :as mu]))

(def app
  (ring/ring-handler
    (ring/router
      [["/swagger.json"
        {:get {:no-doc true
               :swagger {:info {:title "payment-service"
                                :description "payment-service api"
                                :version "0.0.1"}
                         :tags [{:name "payment"
                                 :description "payment api"}]}
               :handler (swagger/create-swagger-handler)}}]
       ["/openapi.json"
        {:get {:no-doc true
               :openapi {:info {:title "payment-service"
                                :description "payment-service api"
                                :version "0.0.1"}}
               :handler (openapi/create-openapi-handler)}}]

       ["/payments"
        {:tags #{"payment"}}

        ["/"
         {:get {:summary "Get list of payments"
                :parameters {:query [:map
                                     [:limit {:title "Limit"
                                              :description "Max n of payments to return in the response"
                                              :json-schema/default 10}
                                      int?]]}
                :responses {200 {:body [:map
                                        [:payments
                                         [:sequential [:map
                                                       [:id int?]
                                                       [:amount int?]
                                                       [:currency [:enum "USD" "GBP" "EUR"]]]]]]}}
                :handler (fn [_]
                           (println "Handling GET /payments")
                           {:status 200
                            :body {:payments [{:id 10
                                               :amount 100
                                               :currency "USD"}
                                              {:id 11
                                               :amount 25
                                               :currency "GBP"}]}})}

          :post {:parameters {:body [:map
                                     [:amount int?]
                                     [:currency [:enum "USD" "GBP" "EUR"]]]}
                 :responses {201 {:body [:map [:payment [:map
                                                         [:id int?]
                                                         [:amount int?]
                                                         [:currency [:enum "USD" "GBP" "EUR"]]]]]}}
                 :handler (fn [{{{:keys [amount currency]} :body} :parameters}]
                            (println "Handling POST /payments")
                            {:status 201
                             :body {:payment {:id 10
                                              :amount amount
                                              :currency currency}}})}}]
        ["/:id" {:get {:summary "Get payment by id"
                       :parameters {:path [:map [:id int?]]}
                       :responses {200 {:body [:map
                                               [:payment
                                                [:map
                                                 [:id int?]
                                                 [:amount int?]
                                                 [:currency [:enum "USD" "GBP" "EUR"]]]]]}}
                       :handler (fn [{{{:keys [id]} :path} :parameters}]
                                  (println "Handling GET /payments/:id" id)
                                  {:status 200
                                   :body {:payment {:id id
                                                    :amount 100
                                                    :currency "USD"}}})}}]]]

      {:validate spec/validate
       :exception pretty/exception
       :data {:coercion (reitit.coercion.malli/create
                          {:error-keys #{:coercion :in :schema :value :errors :humanized}
                           :compile mu/closed-schema
                           :strip-extra-keys true
                           :default-values true
                           :options nil})
              :muuntaja m/instance
              :middleware [swagger/swagger-feature
                           openapi/openapi-feature
                           parameters/parameters-middleware
                           muuntaja/format-negotiate-middleware
                           muuntaja/format-response-middleware
                           exception/exception-middleware
                           muuntaja/format-request-middleware
                           coercion/coerce-response-middleware
                           coercion/coerce-request-middleware
                           multipart/multipart-middleware]}})
    (ring/routes
      (swagger-ui/create-swagger-ui-handler
        {:path "/"
         :config {:validatorUrl nil
                  :urls [{:name "swagger", :url "swagger.json"}
                         {:name "openapi", :url "openapi.json"}]
                  :urls.primaryName "openapi"
                  :operationsSorter "alpha"}})
      (ring/create-default-handler))))

(defn -main
  []
  (println "Starting server")
  (jetty/run-jetty app {:port 8080}))
