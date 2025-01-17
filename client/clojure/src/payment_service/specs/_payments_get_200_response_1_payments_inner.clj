(ns payment-service.specs.-payments-get-200-response-1-payments-inner
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def -payments-get-200-response-1-payments-inner-data
  {
   (ds/req :id) int?
   (ds/req :amount) int?
   (ds/req :currency) string?
   })

(def -payments-get-200-response-1-payments-inner-spec
  (ds/spec
    {:name ::-payments-get-200-response-1-payments-inner
     :spec -payments-get-200-response-1-payments-inner-data}))
