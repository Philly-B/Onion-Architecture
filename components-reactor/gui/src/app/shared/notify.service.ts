import { Injectable } from '@angular/core';
import { MatSnackBarConfig, MatSnackBar } from '@angular/material';

@Injectable({
  providedIn: 'root'
})
export class NotifyService {

  private readonly snackBarDuration: number = 3000;

  public showSnackBar(text: string): void {
    const config: any = new MatSnackBarConfig();
    config.duration = this.snackBarDuration;
    this.snackBar.open(text, 'OK', config);
  }

  constructor(private snackBar: MatSnackBar) { }
}
