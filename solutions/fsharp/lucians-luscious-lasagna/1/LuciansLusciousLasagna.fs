module LuciansLusciousLasagna

let expectedMinutesInOven = 40

let remainingMinutesInOven minutes = expectedMinutesInOven - minutes

let preparationTimeInMinutes numberOfLayers = 2 * numberOfLayers

let elapsedTimeInMinutes numberOfLayers minutes = preparationTimeInMinutes numberOfLayers + minutes
