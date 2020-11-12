import { TestBed } from '@angular/core/testing';

import { PellerinService } from './pellerin.service';

describe('PellerinService', () => {
  let service: PellerinService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PellerinService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
