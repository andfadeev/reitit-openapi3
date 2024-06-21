(ns payment-service.specs.-payments-post-request
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def -payments-post-request-data
  {
   (ds/req :amount) int?
   (ds/req :currency) string?
   })

(def -payments-post-request-spec
  (ds/spec
    {:name ::-payments-post-request
     :spec -payments-post-request-data}))
