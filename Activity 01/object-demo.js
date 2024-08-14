// import { Employee } from "./employees.js";
// import fs from "fs";

// let employee = new Employee(1234, "Anand", 45200);
// employee.display();
// let employeeJSON = employee.toJSON();
// // console.log(employee.toJSON());
// fs.writeFileSync("employee.json", employeeJSON + ",\n", { flag: "a+" })


import { Employee } from "./employees.js";
import fs from "fs";

// Create a new employee instance
let employee = new Employee(1234, "Anand", 45200);
employee.display();
let employeeJSON = employee.toJSON();
console.log(employeeJSON);


if (!fs.existsSync("employee.json")) {
    fs.writeFileSync("employee.json", "[\n" + employeeJSON + "\n]", { flag: "w" });
} else {
    let data = fs.readFileSync("employee.json", "utf8").trim();
    let updatedData = data.slice(0, -1).trim();
    if (updatedData.endsWith("}")) {
        updatedData += ",";
    }
    updatedData += "\n" + employeeJSON + "\n]";
    fs.writeFileSync("employee.json", updatedData, { flag: "w" });
}