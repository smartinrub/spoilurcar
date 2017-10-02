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

  parts: Part[];
  newPart: Part = new Part();

  constructor(private partService: PartService) {}

  createPart(partForm: NgForm): void {

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
}
