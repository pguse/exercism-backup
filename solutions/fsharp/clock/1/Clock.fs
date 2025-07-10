module Clock

open System

let create hours minutes = 
    ( (24+(hours%24))*60 + 1440+(minutes%1440) ) % 1440

let add minutes clock = 
    (clock + minutes) % 1440

let subtract minutes clock = 
    (1440 + (clock - (minutes%1440))) % 1440

let display clock = 
    String.Format("{0:00}:{1:00}", clock / 60, clock % 60 )