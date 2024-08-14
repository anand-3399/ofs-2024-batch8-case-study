export class Employee {
    constructor(id, name, salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    display() {
        console.log(`Id=${this.id}, Name=${this.name}, Salary=${this.salary}`);
    }
    toJSON() {
        return JSON.stringify({
            id: this.id,
            name: this.name,
            salary: this.salary
        }, null, 4);
    }
}