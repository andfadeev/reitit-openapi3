(ns payment-service.specs.-payments-post-201-response
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [payment-service.specs.-payments-get-200-response-1-payments-inner :refer :all]
            )
  (:import (java.io File)))


(def -payments-post-201-response-data
  {
   (ds/req :payment) -payments-get-200-response-1-payments-inner-spec
   })

(def -payments-post-201-response-spec
  (ds/spec
    {:name ::-payments-post-201-response
     :spec -payments-post-201-response-data}))
