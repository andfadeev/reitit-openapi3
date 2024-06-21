(ns payment-service.specs.-payments-get-200-response
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [payment-service.specs.-payments-get-200-response-payments-inner :refer :all]
            )
  (:import (java.io File)))


(def -payments-get-200-response-data
  {
   (ds/req :payments) (s/coll-of -payments-get-200-response-payments-inner-spec)
   })

(def -payments-get-200-response-spec
  (ds/spec
    {:name ::-payments-get-200-response
     :spec -payments-get-200-response-data}))
