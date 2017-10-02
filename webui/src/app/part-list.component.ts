import { Component, Input } from '@angular/core';

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

  createPart(partForm: NgForm): void {

  }

  deletePart(name: string): void {
  }

  confirmDelete(name: string) {
    if (confirm('Are you sure?')) {
      this.deletePart(name);
    }
  }
}
