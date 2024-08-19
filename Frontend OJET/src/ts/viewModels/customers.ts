import * as AccUtils from "../accUtils";
import * as ko from "knockout";
import "oj-c/input-text";
import 'oj-c/form-layout';
import "oj-c/input-number";
import "oj-c/button";
import "ojs/ojtable";
import "ojs/ojknockout";
import { RESTDataProvider } from 'ojs/ojrestdataprovider';
type D = { "id": number, "name": string, "salary": number };
type K = D['id'];
class CustomersViewModel {
  [x: string]: any;
  name: ko.Observable<string> | ko.Observable<any>;
  salary: ko.Observable<number> | ko.Observable<any>;
  restServerUrl: string = "http://localhost:8888/employees";
  dataprovider: RESTDataProvider<K, D> | undefined;
  constructor() {
    this.name = ko.observable(null);
    this.salary = ko.observable(null);


    this.dataprovider = new RESTDataProvider({
      keyAttributes: 'id',
      url: 'http://localhost:8888/employees',
      transforms: {
        fetchFirst: {
          request: async (options) => {
            const url = new URL(options.url);
            return new Request(url.href);
          },
          response: async ({ body }) => {
            let data = body;
            return { data };
          }
        }
      }
    })
  }

  // add to the observableArray
  addRow = async () => {
    // Create row object based on form inputs
    const row = {
      name: this.name(),
      salary: this.salary(),
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
    const addedRow = await response.json();
    console.log(addedRow);
    alert(addedRow.message)

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
    AccUtils.announce("Customers page loaded.");
    document.title = "Customers";
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
export = CustomersViewModel;