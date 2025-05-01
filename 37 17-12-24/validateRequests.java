// The process of initiating an action on a server is done through HTTP requests, 
// which are messages sent by the client. The two most commonly used HTTP 
// requests are GET and POST. This task involves validating requests and parsing 
// URL parameters as a comma-separated string.

// Authentication Tokens:
// 	- For both GET and POST requests, authentication tokens are sent as a 
// 	  URL parameter named "token".
// 	- Validation ensures that the token belongs to a predefined set of valid tokens.

// POST Requests:
// Additionally, a valid POST request requires a CSRF token, which:
// 	- Must be an alphanumeric value.
// 	- Have a length of at most 8.
	
// URL Parsing:
// URL parameters consist of key-value pairs separated by an equal sign = and 
// multiple parameters separated by an ampersand &. 

// For example:
// https://example.com?param1=value1&param2=value2

// If the request is valid, return VALID followed by the parsed URL parameters in 
// a comma-separated string:  VALID, name=value1, id=value2
// If invalid, return INVALID

// Input Format:
// -------------
// Two space separated integers, M and N
// M lines: a string, valid token
// N Lines: comma separated strings, method-type and url-paramater

// Output Format:
// --------------
// N lines of output according to problem statement.

// Sample Input-1:
// ---------------
// 3 2
// et51u819p1q7
// b8nn5j4om76v
// r5b6191mlp09
// GET,https://example.com?token=et51u819p1q7&id=23r&name=alex
// POST,https://example.com?token=r5b6191mlp09&csrf=f1a098idu78&name=evan

// Sample Output-1:
// ----------------
// VALID, name=alex, id=23r
// INVALID


// Sample Input-2:
// ---------------
// 5 3
// acg71288bybi
// rkifz4hkzy3k
// 1ezzh1gyfswh
// hrmkv5b1f7qr
// mvf1pk83na47
// GET,https://example.com?token=mvf1pk83na47&id=0x6&name=xmit
// POST,https://example.com?token=rkifz4hkzy3k&id=int&name=7ad6
// POST,https://example.com?token=1ezzh1gyfswh&id=u82&name=tu7d&csrf=kx0ccyvu

// Sample Output-2:
// ----------------
// VALID, name=xmit, id=0x6
// INVALID
// VALID, name=tu7d, id=u82
