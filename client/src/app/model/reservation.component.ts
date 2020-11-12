import {Hotel} from "./hotel.component";
import {Pellerin} from "./pellerin.component";

export class Reservation {
  id_reservation: number;
  hotel: Hotel;
  pellerin: Pellerin;
  dateReservation: Date;
  action: boolean;

}
