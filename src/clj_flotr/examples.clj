;
;  (C) Copyright 2015  Pavel Tisnovsky
;
;  All rights reserved. This program and the accompanying materials
;  are made available under the terms of the Eclipse Public License v1.0
;  which accompanies this distribution, and is available at
;  http://www.eclipse.org/legal/epl-v10.html
;
;  Contributors:
;      Pavel Tisnovsky
;

(ns clj-flotr.examples)

(require '[hiccup.page         :as page])
(require '[clj-flotr.generator :as generator])



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
                ] ; </table>
                [:h1 "done"]]))))



;
; This function creates HTML page named "test-line-charts.html".
; That page will contain various line-charts that shows how
; the function (generator/line-chart) could be used.
;
(defn test-line-charts
    "Creates HTML page with various types of line-charts."
    []
    (let [data [{:values [[1 1] [2 2] [3 3]] :label "foo"}
                {:values [[1 0] [2 5] [3 0]]  :label "bar"}
                {:values [[1 4] [2 2] [3 4]]  :label "baz"}]]
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
                ] ; </table>
                [:h1 "done"]]))))



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



; You can call example function by using following two lines:
;(test-pie-charts)
;(test-line-charts)
;(test-stacked-bars)


