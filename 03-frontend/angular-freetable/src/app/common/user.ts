import { ReservationItem } from './reservation-item';

export class User {
    id: number;
    username: string;
    email: string;
    reservationItems: ReservationItem[];
}
