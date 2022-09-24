import axios from "axios"
import { useEffect, useState } from "react"
import FeedbackRow from "./SubComponents/FeedbackRow"

const SubmitFeedback = (props) =>{
    const userId = props.location.aboutProps.id.user
    const[Teachers,setTeachers] = useState([])
    const url = "http://localhost:8080"

    useEffect(() =>{
        getTeachersForFeedback()
     },[])

    const getTeachersForFeedback = () =>{
        const body={
            "userId":userId
        }
        axios.post(url+"/feedback/getTeachers",body).then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                setTeachers(result.data)
            }
        })
    }
    return (
        <div className="container"><h4 align="center">Submit Feedback of Id {userId}</h4>
        <br/>
        
        <b>Your Feedbacks : </b>

        <table className="table">
            <thead>
                <tr>
                    <th>Teacher</th>
                    <th>Subject</th>
                    <th>Ratings</th>
                    <th>New Remarks</th>
                    <th>New Ratings</th>
                    <th>Submit/Edit</th>
                </tr>
            </thead>
            <tbody>
                        {                    
                            Teachers.map((teacher) =>{
                            return (
                                    <FeedbackRow t={teacher} />
                                )
                            })
                        }
            </tbody>
        </table>
        
        </div>
    )
}
export default SubmitFeedback