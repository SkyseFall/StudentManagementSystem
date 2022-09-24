import axios from "axios"
import { useEffect, useState } from "react"
import FeedbackRow from "./SubComponents/FeedbackRow"

const ReadFeedback = () =>{
    const [teacher,setTeacher] = useState(0)
    const [teacherList,setTeacherList] = useState([])
    const [feedbackList,setFeedbackList] = useState([])
    const url = "http://localhost:8080"
    useEffect(() =>{
        getAllTeachers()
    },[])
    const getAllTeachers = () =>{
        axios.post(url+"/teacher/all").then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                setTeacherList(result.data)
            }
        })
    }

    const getFeedbackForTeacher = () =>{
        const body = {
            "userId":teacher
        }
        console.log("Teacher - "+teacher)
        axios.post(url+"/feedback/getFeedbackForTeacher",body).then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                setFeedbackList(result.data)
            }
        })
    }

    return (
        <div className="container">
            <table>
                <tr>
                    <td> Select Teacher : </td>
                    <td> <select onChange={e=>{setTeacher(e.target.value)}}>
            <option value={0}>None</option>
            {                    
                teacherList.map((t) =>{
                return (
                    <option value={t.teacherId}>Id:{t.teacherId} - {t.teacherName}</option>
                    )
                })
            }
            </select></td>
                    <td><button className="button-show" onClick={getFeedbackForTeacher}>Show Feedbacks</button>
</td>
                </tr>
            </table>
            <br/>
           
            {/* <button onClick={getClasses}>Get Classes</button> */}

           
                              
            <table class="table">
                <thead >
                    <tr className="tableHead">
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