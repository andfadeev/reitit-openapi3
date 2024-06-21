(defproject reitit-openapi3 "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [metosin/reitit "0.7.0"]
                 [ring/ring-jetty-adapter "1.12.2"]
                 [cheshire "5.13.0"]
                 [metosin/spec-tools "0.7.0"]
                 [clj-http "3.8.0"]
                 [orchestra "2017.11.12-1"]
                 [commons-io/commons-io "2.16.1"]
                 [com.github.oliyh/martian "0.1.26"]
                 [com.github.oliyh/martian-clj-http "0.1.26"]
                 [payment-service/payment-service "0.0.1"]]
  :main ^:skip-aot reitit-openapi3.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
