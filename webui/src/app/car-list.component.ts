import { Component, OnInit } from '@angular/core';
import { CarService } from './car.service';
import { Car } from './car';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-car-list',
  templateUrl: './car-list.component.html',
  styleUrls: ['./car-list.component.css']
})

export class CarListComponent implements OnInit {
  cars: Car[];
  newCar: Car = new Car();
  editingCar: Car = new Car();
  editing: Boolean = false;

  constructor(private carService: CarService) {}

  ngOnInit(): void {
    this.getCars();
  }

  getCars(): void {
    this.carService.getCars().then(cars => this.cars = cars );
  }

  createCar(carForm: NgForm): void {
    this.carService.createCar(this.newCar)
      .then(createdCar => {
        console.log(createdCar);
        carForm.reset();
        this.newCar = new Car();
        this.cars.unshift(createdCar);
      });
  }

  updateCar(carData: Car): void {
    console.log(carData);
    this.carService.updateCar(carData)
      .then(updatedCar => {
        const editingCar = this.cars.find(car => car.id === updatedCar.id);
        Object.assign(editingCar, updatedCar);
        this.exitEditing();
      });
  }

  deleteCar(id: string): void {
    this.carService.deleteCar(id)
      .then(() => this.cars = this.cars.filter(car => car.id !== id));
  }

  confirmDelete(id: string) {
    if (confirm('Are you sure?')) {
      this.deleteCar(id);
    }
  }

  editCar(car: Car): void {
    this.editing = true;
    Object.assign(this.editingCar, car);
  }

  exitEditing(): void {
    this.editingCar = new Car();
    this.editing = false;
  }
}
