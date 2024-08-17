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
import "oj-c/button";
import "oj-c/progress-bar";

class DashboardViewModel {
  id: ko.Observable<number> | ko.Observable<any>;
  value: ko.Observable<string>;
  firstName: ko.Observable<string> | ko.Observable<any>;
  salary: ko.Observable<number> | ko.Observable<any>;
  password: ko.Observable<number> | ko.Observable<any>;
  date: ko.Observable<string> | ko.Observable<any>;
  isContrastBackground: ko.Observable<boolean>;
  address: ko.Observable<string> | ko.Observable<any>;
  email: ko.Observable<string> | ko.Observable<any>;
  username: ko.Observable<string> | ko.Observable<any>;
  constructor() {
    // const corepackDarkContainer = document.getElementById('oj-c-dark-container');
    this.id = ko.observable(null);
    this.value = ko.observable("Green");
    this.firstName = ko.observable(null);
    this.salary = ko.observable(null);
    this.password = ko.observable(null);
    this.date = ko.observable(IntlConverterUtils.dateToLocalIsoDateString(new Date()));
    this.isContrastBackground = ko.observable(false);
    this.address = ko.observable(null);
    this.email = ko.observable(null);
    this.username = ko.observable(null);
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


  /**
   * handleClick
  */
  public handleClick = async (event: Event) => {
    // Identify the tag firstName
    let elementName = (event.currentTarget as HTMLElement).tagName;
    // send request to the REST API
    // alert("You clicked on a button " + elementName);
    // let id = parseInt(this.firstName());
    // alert(`Name: ${this.firstName()} \nSalary: ${this.salary()} \nPassword: ${this.password()} \nDate: ${this.date()}`)
    let URL = "https://jsonplaceholder.typicode.com/users/" + this.id();
    let res = await fetch(URL);
    let jsonData = await res.json()
    console.log(jsonData);
    this.firstName(jsonData.name);
    this.username(jsonData.username);
    this.address(jsonData.address.street + ", " + jsonData.address.suite + ", " + jsonData.address.city + " - " + jsonData.address.zipcode)
    this.email(jsonData.email);
    // alert(`Name: ${jsonData.name} \n Username: ${jsonData.username} \nEmail: ${jsonData.email}`)
  }

  public feildProgress = (event: Event) => {
    let value = 0;
    value += (this.id() != null) ? 12.5 : 0;
    value += (this.username() != null) ? 12.5 : 0;
    value += (this.firstName() != null) ? 12.5 : 0;
    value += (this.salary() != null) ? 12.5 : 0;
    value += (this.password() != null) ? 12.5 : 0;
    value += (this.address() != null) ? 12.5 : 0;
    value += (this.email() != null) ? 12.5 : 0;
    value += (this.date() != null) ? 12.5 : 0;
    return value;
  }

}

export = DashboardViewModel;
