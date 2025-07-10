//
// This is only a SKELETON file for the 'Reverse String' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

export const reverseString = (text) => {
  let newText = "";
  for (let i = text.length-1; i >= 0; i -= 1){
    newText += text[i];
  }
  return newText;
};
