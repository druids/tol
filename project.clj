(defproject tol "0.0.0"
  :description "A Tól is a set of functions that extend Clojure core functions"
  :url "https://github.com/druids/tol"
  :license {:name "MIT License"
            :url "http://opensource.org/licenses/MIT"}

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.946"]]

  :profiles {:dev {:plugins [[lein-cloverage "1.0.10"]
                             [lein-kibit "0.1.6"]]}
             :cljs {:plugins [[lein-cljsbuild "1.1.7"]
                              [lein-doo "0.1.8"]]
                    :doo {:build "test"}
                    :cljsbuild {:builds
                                {:test {:source-paths ["src" "test"]
                                        :compiler {:main tol.runner
                                                   :output-to "target/test/core.js"
                                                   :optimizations :none
                                                   :source-map true
                                                   :pretty-print true
                                                   ;; workaround for running lein doo with latest CLJS, see
                                                   ;; https://github.com/bensu/doo/pull/141}}}}
                                                   :process-shim false}}}}}}
  :aliases {"cljs-tests" ["with-profile" "cljs" "doo" "phantom" "once"]
            "cljs-auto" ["with-profile" "cljs" "cljsbuild" "auto"]
            "cljs-once" ["with-profile" "cljs" "cljsbuild" "once"]})
