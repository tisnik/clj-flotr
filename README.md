# clj-flotr

Library that contains functions to generate various types of graphs
for HTML pages. Graphs are rendered by the Flotr library.

## Installation

Usually no manual installation is required. Just use *Leiningen* or *Maven* to
integrate *clj-flotr* into your project.

### Manual installation

If you don't want to use *Leiningen*, you can manually download project snapshot
from
[https://clojars.org/org.clojars.tisnik/clj-flotr/versions/0.2.0-SNAPSHOT](https://clojars.org/org.clojars.tisnik/clj-flotr/versions/0.2.0-SNAPSHOT)
and integrate the source file into your project. Or simply clone the following
GIT repository:
[https://github.com/tisnik/clj-flotr](https://github.com/tisnik/clj-flotr)

[![Clojars Project](https://img.shields.io/clojars/v/org.clojars.tisnik/clj-flotr.svg)](https://clojars.org/org.clojars.tisnik/clj-flotr)

### Leiningen

    [org.clojars.tisnik/clj-flotr "0.2.0-SNAPSHOT"]

### Gradle

    compile "org.clojars.tisnik:clj-flotr:0.2.0-SNAPSHOT"

### Maven

    <dependency>
        <groupId>org.clojars.tisnik</groupId>
        <artifactId>clj-flotr</artifactId>
        <version>0.2.0-SNAPSHOT</version>
    </dependency>

## Usage

### Pie charts

    ;
    ; This function creates HTML page named "test-pie-charts.html".
    ; That page will contain various pie-charts that shows how
    ; the function (generator/pie-chart) could be used.
    ;
    (defn test-pie-charts
        "Creates HTML page with various types of pie-charts."
        []
        (let [data [{:values 10 :label "foo"}
                    {:values 10 :label "bar"}
                    {:values 30 :label "baz"}]]
            (spit "test-pie-charts.html" (page/xhtml
                [:head
                    [:title "Test Pie Charts"]
                    [:meta {:name "Generator" :content "Clojure"}]
                    [:meta {:http-equiv "Content-type" :content "text/html; charset=utf-8"}]
                    ; we need to include all Flotr JavaScript libraries.
                    (generator/flotr-scripts nil nil nil)
                ]
                [:body
                    [:h1 "Test Pie Charts"]
                    [:table
                        [:tr
                            [:td (generator/pie-chart "chart1" "300px" "300px" data)]
                            [:td (generator/pie-chart "chart2" "300px" "300px" data
                                    :vertical-lines true)]
                            [:td (generator/pie-chart "chart3" "300px" "300px" data
                                    :horizontal-lines true)]
                            [:td (generator/pie-chart "chart4" "300px" "300px" data
                                    :horizontal-lines true
                                    :vertical-lines true)]
                        ] ; </tr>
                        [:tr
                            [:td (generator/pie-chart "chart5" "300px" "300px" data
                                     :show-legend true)]
                            [:td (generator/pie-chart "chart6" "300px" "300px" data
                                     :show-legend true
                                     :legend-position "sw")]
                            [:td (generator/pie-chart "chart7" "300px" "300px" data
                                     :show-legend true
                                     :legend-position "ne"
                                     :legend-background "#D2E8FF")]
                            [:td (generator/pie-chart "chart8" "300px" "300px" data
                                     :show-legend true
                                     :legend-position "sw"
                                     :legend-background "#FFFFFF")]
                        ] ; </tr>
                        [:tr
                            [:td (generator/pie-chart "chart9" "300px" "300px" data
                                     :title "Chart title")]
                            [:td (generator/pie-chart "chart10" "300px" "300px" data
                                     :subtitle "Chart subtitle")]
                            [:td (generator/pie-chart "chart11" "300px" "300px" data
                                     :title "Chart title"
                                     :subtitle "Chart subtitle")]
                            [:td (generator/pie-chart "chart12" "300px" "300px" data
                                     :show-legend true
                                     :legend-position "sw"
                                     :legend-background "#FFFFFF"
                                     :title "Chart title"
                                     :subtitle "Chart subtitle")]
                        ] ; </tr>
                    ] ; </table>
                    [:h1 "done"]]))))

### Line charts

    ;
    ; This function creates HTML page named "test-line-charts.html".
    ; That page will contain various line-charts that shows how
    ; the function (generator/line-chart) could be used.
    ;
    (defn test-line-charts
        "Creates HTML page with various types of line-charts."
        []
        (let [data [{:values [[1 1] [2 2] [3 3]] :label "foo"}
                    {:values [[1 0] [2 5] [3 0]] :label "bar"}
                    {:values [[1 4] [2 2] [3 4]] :label "baz"}]]
            (spit "test-line-charts.html" (page/xhtml
                [:head
                    [:title "Test Line Charts"]
                    [:meta {:name "Generator" :content "Clojure"}]
                    [:meta {:http-equiv "Content-type" :content "text/html; charset=utf-8"}]
                    ; we need to include all Flotr JavaScript libraries.
                    (generator/flotr-scripts nil nil nil)
                ]
                [:body
                    [:h1 "Test Line Charts"]
                    [:table
                        [:tr
                            [:td (generator/line-chart "chart1" "300px" "300px" data)]
                            [:td (generator/line-chart "chart2" "300px" "300px" data
                                    :vertical-lines true)]
                            [:td (generator/line-chart "chart3" "300px" "300px" data
                                    :horizontal-lines true)]
                            [:td (generator/line-chart "chart4" "300px" "300px" data
                                    :horizontal-lines true
                                    :vertical-lines true)]
                        ] ; </tr>
                        [:tr
                            [:td (generator/line-chart "chart5" "300px" "300px" data
                                     :show-legend true)]
                            [:td (generator/line-chart "chart6" "300px" "300px" data
                                     :show-legend true
                                     :legend-position "sw")]
                            [:td (generator/line-chart "chart7" "300px" "300px" data
                                     :show-legend true
                                     :legend-position "ne"
                                     :legend-background "#D2E8FF")]
                            [:td (generator/line-chart "chart8" "300px" "300px" data
                                     :show-legend true
                                     :legend-position "sw"
                                     :legend-background "#FFFFFF")]
                        ] ; </tr>
                        [:tr
                            [:td (generator/line-chart "chart9" "300px" "300px" data
                                     :title "Chart title")]
                            [:td (generator/line-chart "chart10" "300px" "300px" data
                                     :subtitle "Chart subtitle")]
                            [:td (generator/line-chart "chart11" "300px" "300px" data
                                     :title "Chart title"
                                     :subtitle "Chart subtitle")]
                            [:td (generator/line-chart "chart12" "300px" "300px" data
                                     :title "Chart title"
                                     :subtitle "Chart subtitle"
                                     :horizontal-lines true
                                     :vertical-lines true
                                     :show-legend true
                                     :legend-position "sw"
                                     :legend-background "#FFFFFF")]
                        ] ; </tr>
                    ] ; </table>
                    [:h1 "done"]]))))

### Stacked bars charts

    ;
    ; This function creates HTML page named "test-stacked-bars.html".
    ; That page will contain various pie-charts that shows how
    ; the function (generator/stacked-bars) could be used.
    ;
    (defn test-stacked-bars
        "Creates HTML page with various types of stacked-bars chart."
        []
        (let [data [{:values [[0 1] [1 2] [2 3] [3 3]] :label "foo"}
                    {:values [[0 1] [1 4] [2 6] [3 6]] :label "bar"}
                    {:values [[0 0] [1 1] [2 0] [3 0]] :label "baz"}]]
            (spit "test-stacked-bars.html" (page/xhtml
                [:head
                    [:title "Test Stacked Bars"]
                    [:meta {:name "Generator" :content "Clojure"}]
                    [:meta {:http-equiv "Content-type" :content "text/html; charset=utf-8"}]
                    ; we need to include all Flotr JavaScript libraries.
                    (generator/flotr-scripts nil nil nil)
                ]
                [:body
                    [:h1 "Test Stacked Bars"]
                    [:table
                        [:tr
                            [:td (generator/stacked-bars "chart1" "300px" "300px" data)]
                            [:td (generator/stacked-bars "chart2" "300px" "300px" data
                                    :vertical-lines true)]
                            [:td (generator/stacked-bars "chart3" "300px" "300px" data
                                    :horizontal-lines true)]
                            [:td (generator/stacked-bars "chart4" "300px" "300px" data
                                    :horizontal-lines true
                                    :vertical-lines true)]
                        ] ; </tr>
                        [:tr
                            [:td (generator/stacked-bars "chart5" "300px" "300px" data
                                     :show-legend true)]
                            [:td (generator/stacked-bars "chart6" "300px" "300px" data
                                     :show-legend true
                                     :legend-position "sw")]
                            [:td (generator/stacked-bars "chart7" "300px" "300px" data
                                     :show-legend true
                                     :legend-position "ne"
                                     :legend-background "#D2E8FF"
                                     :bar-width "0.1")]
                            [:td (generator/stacked-bars "chart8" "300px" "300px" data
                                     :show-legend true
                                     :legend-position "sw"
                                     :legend-background "#FFFFFF"
                                     :bar-width "1")]
                        ] ; </tr>
                    ] ; </table>
                    [:h1 "done"]]))))


## Leiningen targets

The following *Leiningen* targets are supported by the current version of this module:

### Run unit tests

    lein test

### Measure code coverage

    lein cloverage

### Generate or regenerate documentation

    lein doc

### Bugs

## License

Copyright © 2015, 2016  Pavel Tisnovsky

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

