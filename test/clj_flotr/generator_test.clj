;
;  (C) Copyright 2015, 2016  Pavel Tisnovsky
;
;  All rights reserved. This program and the accompanying materials
;  are made available under the terms of the Eclipse Public License v1.0
;  which accompanies this distribution, and is available at
;  http://www.eclipse.org/legal/epl-v10.html
;
;  Contributors:
;      Pavel Tisnovsky
;

(ns clj-flotr.generator-test
  (:require [clojure.test :refer :all]
            [clj-flotr.generator :refer :all]))

(deftest test-line-chart-existence
    (testing "Test if line-chart function exists"
        (is (function? line-chart))))

(deftest test-pie-chart-existence
    (testing "Test if pie-chart function exists"
        (is (function? pie-chart))))

(deftest test-stacked-bars-existence
    (testing "Test if stacked-bars function exists"
        (is (function? stacked-bars))))

(deftest test-script-existence
    (testing "Test if script function exists"
        (is (function? script))))

(deftest test-flotr-scripts-existence
    (testing "Test if flotr-scripts function exists"
        (is (function? flotr-scripts))))

(deftest test-bool->string-existence
    (testing "Test if bool->string function exists"
        (is (function? bool->string))))

(deftest test-data-series-for-pie-chart-existence
    (testing "Test if data-series-for-pie-chart function exists"
        (is (function? data-series-for-pie-chart))))

(deftest test-vals->js-existence
    (testing "Test if vals->js function exists"
        (is (function? vals->js))))

(deftest test-data-series-for-line-chart-existence
    (testing "Test if data-series-for-line-chart function exists"
        (is (function? data-series-for-line-chart))))

(deftest test-data-series-for-stacked-bars-existence
    (testing "Test if data-series-for-stacked-bars function exists"
        (is (function? data-series-for-stacked-bars))))

(deftest test-legend-part-existence
    (testing "Test if legend-part function exists"
        (is (function? legend-part))))

(deftest test-grid-part-existence
    (testing "Test if grid-part function exists"
        (is (function? grid-part))))

;
; Unit tests
;

(deftest test-bool->string-1
    (testing "Test the function bool->string"
        (are [x y] (= x y)
            "false" (bool->string false)
            "false" (bool->string nil))))

(deftest test-bool->string-2
    (testing "Test the function bool->string"
        (are [x y] (= x y)
            "true" (bool->string true)
            "true" (bool->string 42)
            "true" (bool->string "foobar")
            "true" (bool->string '())
            "true" (bool->string [])
            "true" (bool->string {})
            "true" (bool->string #{}))))

