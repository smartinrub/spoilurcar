import { Component, Input } from '@angular/core';
import { PartService } from './part.service';

import { NgForm } from '@angular/forms';

import { Car } from './car';
import { Part } from './part';

@Component({
  selector: 'app-part-list',
  templateUrl: 'part-list.component.html'
})

export class PartListComponent {

  @Input() car: Car;

  newPart: Part = new Part();
  editingPart: Part = new Part();
  editing: Boolean = false;

  constructor(private partService: PartService) {}

  // function to create new part and pass it to the service
  // only use partForm variable to reset the form because
  // this variable only contains a string
  // newPart object is filled on html document and it is pass
  // it to the service
  createPart(partForm: NgForm): void {
    this.partService.createPart(this.car.id, this.newPart)
      .then(createdPart => {
        console.log(createdPart);
        partForm.reset();
        this.newPart = new Part();
        this.car.parts.unshift(createdPart);
      });
  }

  updatePart(carId: string, partData: Part): void {
    console.log(partData);
    this.partService.updatePart(carId, partData)
    .then(updatedPart => {
      const editingPart = this.car.parts.find(part => part.name === updatedPart.name);
      Object.assign(editingPart, updatedPart);
      this.exitEditing();
    });

  }

  deletePart(carId: string, partName: string): void {
    this.partService.deletePart(carId, partName)
      .then(() => this.car.parts = this.car.parts.filter(part => part.name !== partName));
  }

  confirmDelete(name: string, partName: string) {
    if (confirm('Are you sure?')) {
      this.deletePart(name, partName);
    }
  }

  editPart(part: Part): void {
    this.editing = true;
    Object.assign(this.editingPart, part);
  }

  exitEditing(): void {
    this.editingPart = new Part();
    this.editing = false;
  }
}
