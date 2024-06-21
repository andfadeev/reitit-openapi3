(ns payment-service.specs.-payments-get-200-response-1
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [payment-service.specs.-payments-get-200-response-1-payments-inner :refer :all]
            )
  (:import (java.io File)))


(def -payments-get-200-response-1-data
  {
   (ds/req :payments) (s/coll-of -payments-get-200-response-1-payments-inner-spec)
   })

(def -payments-get-200-response-1-spec
  (ds/spec
    {:name ::-payments-get-200-response-1
     :spec -payments-get-200-response-1-data}))
