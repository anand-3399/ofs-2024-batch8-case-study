/**
 * @license
 * Copyright (c) 2014, 2024, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */
import * as AccUtils from "../accUtils";
import * as ko from "knockout";
import "oj-c/input-text";
import 'oj-c/form-layout';
import "oj-c/input-number";
import "oj-c/button";
import "ojs/ojtable";
import "ojs/ojknockout";
import 'oj-c/input-password';

class RegisterViewModel {
  firstName: ko.Observable<string> | ko.Observable<any>;
  lastName: ko.Observable<string> | ko.Observable<any>;
  age: ko.Observable<number> | ko.Observable<any>;
  gender: ko.Observable<string> | ko.Observable<any>;
  mobile: ko.Observable<number> | ko.Observable<any>;
  email: ko.Observable<string> | ko.Observable<any>;
  address: ko.Observable<string> | ko.Observable<any>;
  pan: ko.Observable<string> | ko.Observable<any>;
  aadhar: ko.Observable<number> | ko.Observable<any>;
  loginId: ko.Observable<string> | ko.Observable<any>;
  password: ko.Observable<number> | ko.Observable<any>;
  restServerUrl: string = "http://localhost:8080/bank/addcustomer";
  constructor() {
    this.firstName = ko.observable(null);
    this.lastName = ko.observable(null);
    this.age = ko.observable(null);
    this.gender = ko.observable(null);
    this.mobile = ko.observable(null);
    this.email = ko.observable(null);
    this.address = ko.observable(null);
    this.pan = ko.observable(null);
    this.aadhar = ko.observable(null);
    this.loginId = ko.observable(null);
    this.password = ko.observable(null);
  }


  addRow = async () => {
    // Create row object based on form inputs
    const row = {
      firstName: this.firstName(),
      lastName: this.lastName(),
      age: this.age(),
      gender: this.gender(),
      mobile: this.mobile(),
      email: this.email(),
      address: this.address(),
      pan: this.pan(),
      aadhar: this.aadhar(),
      login: {
        loginId: this.loginId(),
        password: this.password(),
      }
    };
    // Create and send request to REST service to add row
    const request = new Request(this.restServerUrl, {
      headers: new Headers({
        "Content-type": "application/json; charset=UTF-8",
      }),
      body: JSON.stringify(row),
      method: "POST",
    });
    const response = await fetch(request);
    const responseJson = await response.json();
    console.log(response);
    console.log(responseJson);
    alert(`LoginId: ${responseJson.login.loginId} \nCustomerId: ${responseJson.customerId}`);

  };


  /**
   * Optional ViewModel method invoked after the View is inserted into the
   * document DOM.  The application can put logic that requires the DOM being
   * attached here.
   * This method might be called multiple times - after the View is created
   * and inserted into the DOM and after the View is reconnected
   * after being disconnected.
   */
  connected(): void {
    AccUtils.announce("About page loaded.");
    document.title = "About";
    // implement further logic if needed
  }

  /**
   * Optional ViewModel method invoked after the View is disconnected from the DOM.
   */
  disconnected(): void {
    // implement if needed
  }

  /**
   * Optional ViewModel method invoked after transition to the new View is complete.
   * That includes any possible animation between the old and the new View.
   */
  transitionCompleted(): void {
    // implement if needed
  }
}

export = RegisterViewModel;