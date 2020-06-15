;
;  (C) Copyright 2015, 2020  Pavel Tisnovsky
;
;  All rights reserved. This program and the accompanying materials
;  are made available under the terms of the Eclipse Public License v1.0
;  which accompanies this distribution, and is available at
;  http://www.eclipse.org/legal/epl-v10.html
;
;  Contributors:
;      Pavel Tisnovsky
;

(defproject org.clojars.tisnik/clj-flotr "0.2.0-SNAPSHOT"
    :description "Simple generator for Flotr charts."
    :url "https://github.com/tisnik/clj-flotr"
    :license {:name "Eclipse Public License"
              :url "http://www.eclipse.org/legal/epl-v10.html"}
    :dependencies [[org.clojure/clojure "1.8.0"]
                   [hiccup "1.0.4"]]
    :plugins [[test2junit "1.1.0"]
              [codox "0.8.11"]
              [lein-cloverage "1.0.6"]])
