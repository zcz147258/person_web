import { postData, getData,Postdownload } from './http.js'
export function Login(data = {}){
    return postData('/login', data);
}
export function GetInfo(data = {}){
    return getData('/getinfo',data);
}
export function PlayVideo(data = {}){
    return getData('/playvideo',data);
}
export function Download(data = {}){
    return Postdownload('/download',data);
}