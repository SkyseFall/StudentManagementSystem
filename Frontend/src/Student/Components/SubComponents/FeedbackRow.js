import axios from "axios"
import { useState } from "react"
import { useHistory } from "react-router";


const FeedbackRow = ({t}) =>{

    const [remarks,setRemarks] = useState("")
    const [rating,setRatings] = useState(-1)
    const url = "http://localhost:8080"
    const history = useHistory()

    const saveRatings = () =>{
        if(rating == -1){
            window.alert("please add ratings")
        }else if(rating < 0 || rating > 5){
            window.alert("Please add the valid rating")
        }
        else{
            const body = {
                "studentId":t.studentId,
                "teacherId":t.teacherId,
                "teacherName":t.teacherName,
                "subjectName":t.subjectName,
                "feedbackRemarks":remarks,
                "feedBackRatings":rating
            }
            axios.post(url+"/feedback/saveRatings",body).then(Response =>{
                const result = Response.data
                if(result.status == "success"){
                    window.alert("Feedback added successfully!!")
                    history.push("/studentHome")
                }
            })
        }
        
    }

    return (
        <form action="/addFeedback">
            <tr>
            <td>{t.teacherName}</td>
            <td>{t.subjectName}</td>
            <td>{t.feedBackRatings}/<b>5</b></td>
            <td>
                <input type="text" required onChange={e=>{setRemarks(e.target.value)}} />
            </td>
            <td>
                <input type="number" required onChange={e=>{setRatings(e.target.value)}} />
            </td>
            <td>
                <button className="button-edit" onClick={saveRatings} >Change</button>
            </td>
        </tr>
        </form>
    )
}
export default FeedbackRow