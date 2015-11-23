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

(ns clj-flotr.generator)

(require '[hiccup.page :as page])

(defn script
    "Returns Hiccup-compatible vector containing link to JavaScript source."
    [prefix name]
    [:script {:type "text/javascript" :src (str prefix name)}])

(defn flotr-scripts
    "Use this function to get part of HTML header that contains links
     to Flotr JavaScript libraries.
     Usage: (flotr-script nil \"flotr/lib\")
            (flotr-script \"http://foo.bar.bz\" \"flotr/lib\")
            (flotr-script \"http://foo.bar.bz\" \"flotr/lib\" true)"
    [url path use-debug-variant?]
    (let [prefix (if url (str url ":" path "/")
                         (if path (str path "/") ""))]
          (seq [(script prefix "lib/prototype-1.6.0.2.js")
                (script prefix "lib/canvas2image.js")
                (script prefix "lib/canvastext.js")
                (if use-debug-variant?
                    (script prefix "flotr.debug-0.2.0-alpha.js")
                    (script prefix "flotr-0.2.0-alpha.js"))])))

(defn bool->string
    [value]
    (if value "true" "false"))

(defn data-series-for-pie-chart
    [data]
    (for [datum data]
        (str "{data:[[1," (:values datum) "]], label: '" (:label datum) "'},\n")))

(defn vals->js
    [datum]
    (for [i (:values datum)] (str "[" (first i) "," (second i) "]")))

(defn data-series-for-line-chart
    [data]
    (for [datum data]
        (str "{data:["
            (clojure.string/join ","
                (vals->js datum))
            "],"
            "label: '" (:label datum) "'},\n")))

(defn data-series-for-stacked-bars
    [data]
    (for [datum data]
        (str "{data:["
            (clojure.string/join ","
                (vals->js datum))
            "],"
            "label: '" (:label datum) "'},\n")))

(defn pie-chart
    "Creates a simple pie chart. Please look at the function named
     'test-pie-charts' how to use pie-chart."
    [id width height data & {:keys [horizontal-lines
                                    vertical-lines
                                    show-legend
                                    legend-position
                                    legend-background]}]
    [:div {:id id :style (str "width:" width ";height:" height)}
        [:script {:type "text/javascript"}
            (str "Flotr.draw($('" id "'), [")
                  (data-series-for-pie-chart data)
                  "], {"
            (str "
                  HtmlText: false, 
                  grid: {
                      verticalLines:   " (bool->string vertical-lines) ",
                      horizontalLines: " (bool->string horizontal-lines) "
                  },
                  xaxis: {showLabels: false},
                  yaxis: {showLabels: false}, 
                  pie: {show: true, explode: 5},
                  legend:{
                      show: "             (bool->string show-legend) ",
                      position: '"        (or legend-position "ne") "',
                      backgroundColor: '" (or legend-background "#D2E8FF") "',
                  }});")]])

(defn line-chart
    "Creates a simple bar chart. Please look at the function named
     'test-line-charts' how to use line-chart."
    [id width height data & {:keys [horizontal-lines
                                    vertical-lines
                                    show-legend
                                    legend-position
                                    legend-background]}]
    [:div {:id id :style (str "width:" width ";height:" height)}
        [:script {:type "text/javascript"}
            (str "Flotr.draw($('" id "'), [")
                  (data-series-for-line-chart data)
                  "], {"
            (str "
                  HtmlText: false, 
                  grid: {
                      verticalLines:   " (bool->string vertical-lines) ",
                      horizontalLines: " (bool->string horizontal-lines) "
                  },
                  xaxis: {showLabels: true},
                  yaxis: {showLabels: true}, 
                  legend:{
                      show: "             (bool->string show-legend) ",
                      position: '"        (or legend-position "ne") "',
                      backgroundColor: '" (or legend-background "#D2E8FF") "',
                  }});")]])

(defn stacked-bars
    [id width height data & {:keys [horizontal-lines
                                    vertical-lines
                                    show-legend
                                    legend-position
                                    legend-background
                                    bar-width]}]
    [:div {:id id :style (str "width:" width ";height:" height)}
        [:script {:type "text/javascript"}
            (str "Flotr.draw($('" id "'), [")
                  (data-series-for-stacked-bars data)
                  "], {"
            (str "
                  HtmlText: false, 
                  grid: {
                      verticalLines:   " (bool->string vertical-lines) ",
                      horizontalLines: " (bool->string horizontal-lines) "
                  },
                  xaxis: {showLabels: true},
                  yaxis: {showLabels: true}, 
                  bars: {show: true, stacked: true, barWidth: " (or bar-width "0.5") "},
                  legend:{
                      show: "             (bool->string show-legend) ",
                      position: '"        (or legend-position "ne") "',
                      backgroundColor: '" (or legend-background "#D2E8FF") "',
                  }});")]])

