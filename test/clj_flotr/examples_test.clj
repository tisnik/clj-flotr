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

(ns clj-flotr.examples-test
  (:require [clojure.test :refer :all]
            [clj-flotr.examples :refer :all]))

(deftest test-line-charts-existence
    (testing "Test if test-line-charts-function exists"
        (is (function? test-line-charts))))

(deftest test-pie-charts-existence
    (testing "Test if test-pie-charts-function exists"
        (is (function? test-pie-charts))))

(deftest test-stacked-bars-existence
    (testing "Test if test-stacked-bars-function exists"
        (is (function? test-stacked-bars))))

(deftest test-line-charts-function
    (testing "Test the line chart generation"
        (test-line-charts)))

(deftest test-pie-charts-function
    (testing "Test the pie chart generation"
        (test-pie-charts)))

(deftest test-stacked-bars-function
    (testing "Test the stacked bars generation"
        (test-stacked-bars)))

