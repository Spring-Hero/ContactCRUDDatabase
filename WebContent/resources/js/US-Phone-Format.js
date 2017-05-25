window.onload = usPhoneFormat;

function usPhoneFormat() {
	//	retrieve all phoneNumbers via class
    var phoneNumbers = document.getElementsByClassName("mobile");
    
    //	loop through every phoneNumber
    	for (i = 0; i < phoneNumbers.length; i++) {
        
    		// read inner html of the number
    			var originalNumber = phoneNumbers[i].innerHTML;
    		// process, and update the number
    			phoneNumbers[i].innerHTML = updateFormat(originalNumber);
    	
    }
}

function updateFormat(phoneNumber){
	

	var a=phoneNumber.substring(0,3);
    var b=phoneNumber.substring(3,6);
    var c=phoneNumber.substring(6);
    
    return "("+a+ ")"+b+"-"+c;
}
