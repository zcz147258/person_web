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
export function GetAuthority(data = {}){
    return getData('/authority',data)
}
export function PostBlog(data = {}){
    return postData('/postblog',data);
}
export function GetBlog(data = {}){
    return getData('/getblog',data);
}
export function SignOn(data = {}){
    return postData('/sigon',data);
}
export function Send(data = {}){
    return postData('/email',data);
}