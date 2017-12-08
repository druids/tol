(defproject tol "0.0.0"
  :description "A Tól is a set of functions that extend Clojure core functions"
  :url "https://github.com/druids/tol"
  :license {:name "MIT License"
            :url "http://opensource.org/licenses/MIT"}

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.495"]]

  :profiles {:dev {:plugins [[lein-cloverage "1.0.9"]
                             [lein-kibit "0.1.3"]]}
             :cljs {:plugins [[lein-cljsbuild "1.1.7"]
                              [lein-doo "0.1.8"]]
                    :doo {:build "test"}
                    :cljsbuild {:builds
                                {:test {:source-paths ["src" "test"]
                                        :compiler {:main tol.runner}
                                                  :output-to "target/test/core.js"
                                                  :target :nodejs
                                                  :optimizations :none
                                                  :source-map true
                                                  :pretty-print true}}}
                    :prep-tasks [["cljsbuild" "once"]]
                    :hooks [leiningen.cljsbuild]}}
  :aliases {"cljs-tests" ["with-profile" "cljs" "doo" "node" "once"]
            "cljs-auto" ["with-profile" "cljs" "cljsbuild" "auto"]
            "cljs-once" ["with-profile" "cljs" "cljsbuild" "once"]})
