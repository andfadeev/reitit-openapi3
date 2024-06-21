(ns reitit-openapi3.client
  (:require [payment-service.core :as core]
            [payment-service.api.payment :as payment]
            [martian.core :as martian]
            [martian.clj-http :as martian-http]))

(core/set-api-context
  (assoc core/default-api-context
         :base-url "http://localhost:8080"))

(comment
  (payment/payments-get 10)
  (payment/payments-id-get 1)
  (payment/payments-post
    {:-payments-post-request
     {:amount 100
      :currency "GBP"}}))

;; Alternative is Martian library (different approach)
(comment
  (let [m (martian-http/bootstrap-openapi "http://localhost:8080/openapi.json")]
    (keys m)
    (martian/response-for m :create-pet {:name "Doggy McDogFace" :type "Dog" :age 3})

    (martian/response-for m :get-pet {:id 123})))
