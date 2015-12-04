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

