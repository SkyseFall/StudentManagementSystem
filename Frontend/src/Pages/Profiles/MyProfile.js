import axios from "axios"
import { useEffect, useState } from "react"
import { useHistory } from "react-router"

const MyProfile = (props) =>{
    const history = useHistory();
    const userId = props.location.aboutProps.id.user;
    const url = "http://localhost:8080";

    useEffect(() =>{
        getProfile()
    },[])

    const getProfile = () =>{
        const body ={
            "userId" : userId
        }
        console.log("userId : "+userId )
        
            axios.post(url+"/users/getProfile",body).then(Response =>{
                const result = Response.data
                if(result.status == "success"){
                    //console.log(result.data)
                    //console.log(result.data.typeJob)
                    if(result.data.typeJob == "teacher"){
                        history.push({
                            pathname:'/teacherProfile',
                            // search: '?query=abc',
                            state: result.data
                        })
                    }else if (result.data.typeJob == "student"){
                        history.push({
                            pathname:'/studentProfile',
                            // search: '?query=abc',
                            state: result.data
                        })
                    }else{
                        //console.log(result.data)
                        history.push({
                            pathname:'/adminProfile',
                            // search: '?query=abc',
                            state: result.data
                        })
                    }
                }
            })
        }
        return(
            <div>
            </div>
        )
}
export default MyProfile