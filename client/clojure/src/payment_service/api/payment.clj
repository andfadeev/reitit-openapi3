(ns payment-service.api.payment
  (:require [payment-service.core :refer [call-api check-required-params with-collection-format *api-context*]]
            [clojure.spec.alpha :as s]
            [spec-tools.core :as st]
            [orchestra.core :refer [defn-spec]]
            [payment-service.specs.-payments-post-201-response :refer :all]
            [payment-service.specs.-payments-get-200-response-1-payments-inner :refer :all]
            [payment-service.specs.-payments-post-request :refer :all]
            [payment-service.specs.-payments-get-200-response-payments-inner :refer :all]
            [payment-service.specs.-payments-get-200-response-1 :refer :all]
            [payment-service.specs.-payments-get-200-response :refer :all]
            )
  (:import (java.io File)))


(defn-spec payments-get-with-http-info any?
  "Get list of payments"
  [limit int?]
  (check-required-params limit)
  (call-api "/payments/" :get
            {:path-params   {}
             :header-params {}
             :query-params  {"limit" limit }
             :form-params   {}
             :content-types []
             :accepts       ["application/json" "application/transit+msgpack" "application/transit+json" "application/edn"]
             :auth-names    []}))

(defn-spec payments-get -payments-get-200-response-spec
  "Get list of payments"
  [limit int?]
  (let [res (:data (payments-get-with-http-info limit))]
    (if (:decode-models *api-context*)
       (st/decode -payments-get-200-response-spec res st/string-transformer)
       res)))


(defn-spec payments-id-get-with-http-info any?
  "Get payment by id"
  [id int?]
  (check-required-params id)
  (call-api "/payments/{id}" :get
            {:path-params   {"id" id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json" "application/transit+msgpack" "application/transit+json" "application/edn"]
             :auth-names    []}))

(defn-spec payments-id-get -payments-post-201-response-spec
  "Get payment by id"
  [id int?]
  (let [res (:data (payments-id-get-with-http-info id))]
    (if (:decode-models *api-context*)
       (st/decode -payments-post-201-response-spec res st/string-transformer)
       res)))


(defn-spec payments-post-with-http-info any?
  ""
  ([] (payments-post-with-http-info nil))
  ([{:keys [-payments-post-request]} (s/map-of keyword? any?)]
   (call-api "/payments/" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    -payments-post-request
              :content-types ["application/json" "application/transit+msgpack" "application/transit+json" "application/edn"]
              :accepts       ["application/json" "application/transit+msgpack" "application/transit+json" "application/edn"]
              :auth-names    []})))

(defn-spec payments-post -payments-post-201-response-spec
  ""
  ([] (payments-post nil))
  ([optional-params any?]
   (let [res (:data (payments-post-with-http-info optional-params))]
     (if (:decode-models *api-context*)
        (st/decode -payments-post-201-response-spec res st/string-transformer)
        res))))


