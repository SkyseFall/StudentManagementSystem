import axios from "axios"
import { useEffect, useState } from "react"
import FeedbackRow from "./SubComponents/FeedbackRow"


const ReadFeedback = (props) =>{
    const userId = props.location.aboutProps.id.user
    const [feedbackList,setFeedbackList] = useState([])
    const url = "http://localhost:8080"
    useEffect(() =>{
        getFeedbackForTeacher()
    },[])
    

    const getFeedbackForTeacher = () =>{
        const body = {
            "userId":userId
        }
        axios.post(url+"/feedback/getFeedbackForTeacher",body).then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                setFeedbackList(result.data)
            }
        })
    }

    return (
        <div className="container"><h4 align="center">Feedback</h4>
            <br/>
            <table class="table">
                <thead>
                    <tr>
                        <th>Student Name</th>
                        <th>Class</th>
                        <th>Subject</th>
                        <th>Ratings</th>
                        <th>Remarks</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    {
                        feedbackList.map(fb =>{
                            return <FeedbackRow f={fb} />
                        })
                    }
                </tbody>
            </table>
        </div>
    )
}
export default ReadFeedback