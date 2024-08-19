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


class LoginViewModel {
    loginId: ko.Observable<string> | ko.Observable<any>;
    password: ko.Observable<number> | ko.Observable<any>;
    restServerUrl: string = "http://localhost:8080/bank/checklogin";

    constructor() {

        this.loginId = ko.observable(null);
        this.password = ko.observable(null);
    }

    addRow = async () => {
        // Create row object based on form inputs
        const row = {
            loginId: this.loginId(),
            password: this.password(),
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
        // const responseText = await response.text();
        // console.log(response);
        // console.log(responseText);
        // alert(responseText);
        try {
            // const addedRow = await response.json();
            if (response.ok) {
                // If login is successful
                // const addedRow = await response.json();
                alert('Login successful!');
                sessionStorage.setItem("loginId", this.loginId());
                sessionStorage.setItem("password", this.password());
                window.location.href = "/?ojr=customerDetails";
            } else if (response.status === 401) {
                // If login fails (e.g., incorrect password)
                alert('Incorrect login or password. Please try again.');
            }
            else if (response.status === 423) {
                alert('Account is blocked! Please contact the admin')
            }
            else {
                // Handle other possible errors
                alert('Login ID not found');
            }
        } catch (error) {
            // Handle network or other errors
            alert('An error occurred while processing your request. Please try again later.');
        }

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
        AccUtils.announce("Login page loaded.");
        document.title = "Login";
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

export = LoginViewModel;