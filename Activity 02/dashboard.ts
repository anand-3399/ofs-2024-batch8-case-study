/**
 * @license
 * Copyright (c) 2014, 2024, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */
import * as AccUtils from "../accUtils";
import * as ko from "knockout";
import * as Bootstrap from "ojs/ojbootstrap";
import "oj-c/input-text";
import "ojs/ojknockout";
import "oj-c/input-number";
import 'oj-c/input-password';
import "ojs/ojlabel";
import 'oj-c/form-layout';
import 'ojs/ojdatetimepicker';
import { IntlConverterUtils } from 'ojs/ojconverterutils-i18n';
import 'ojs/ojswitch';
class DashboardViewModel {
  value: ko.Observable<string>;
  name: ko.Observable<string> | ko.Observable<any>;
  salary: ko.Observable<number> | ko.Observable<any>;
  password: ko.Observable<number> | ko.Observable<any>;
  date: ko.Observable<string> | ko.Observable<any>;
  isContrastBackground: ko.Observable<boolean>;
  constructor() {
    // const corepackDarkContainer = document.getElementById('oj-c-dark-container');
    this.value = ko.observable("Green");
    this.name = ko.observable(null);
    this.salary = ko.observable(null);
    this.password = ko.observable(null);
    this.date = ko.observable(IntlConverterUtils.dateToLocalIsoDateString(new Date()));
    this.isContrastBackground = ko.observable(false);
    this.isContrastBackground.subscribe(function (newValue) {
      // div for legacy components
      let darkContainer = document.getElementById('dark-container');
      if (darkContainer != null) {
        if (newValue) {
          darkContainer.className = 'oj-panel oj-bg-neutral-170 oj-color-invert';
          // corepackDarkContainer.className = 'oj-panel oj-bg-neutral-170 oj-color-invert oj-c-colorscheme-dependent';
        } else {
          darkContainer.className = 'oj-panel';
          // corepackDarkContainer.className = 'oj-panel';
        }
      }
    });

  }

}

export = DashboardViewModel;
