import axios from "axios";
import { useEffect, useState } from "react";
import { useHistory } from "react-router";
import ScheduleRow from "./SubComponents/ScheduleRow";

const ViewSchedule = () =>{

    const [classList,setClassList] = useState([])
    const [c,setC] = useState("1");
    const [scheduleList,setScheduleList] = useState([])
    const [teacherList,setTeacherList] = useState([])
    const [teacher,setTeacher] = useState("")

    const history = useHistory()

    const url = "http://localhost:8080"
     useEffect(() =>{
         getClasses()
     },[])

    const getClasses = () =>{
        axios.get(url+"/class/getDistinctClasses").then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                setClassList(result.data)
            }else if(result.status == "zero"){
                window.alert(result.message)
                history.push('/AdminHome')
            }
        })  
        axios.post(url+"/teacher/getNameAndId").then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                setTeacherList(result.data)
            }
        })
    }

    const showScheduleByClass = () =>{
        const body ={
            "std":c
        }
        axios.post(url+"/schedule/getByClass",body).then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                setScheduleList(result.data)
            }
        })  
    }

    const showScheduleByTeacher = () =>{
        console.log(teacher)
        const body ={
            "userId" : teacher
        }
        axios.post(url+"/schedule/getByTeacherId",body).then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                setScheduleList(result.data)
            }
        })
    }
    return (
        <div className="container">
            <br />
            Select Class : 
            {/* <button onClick={getClasses}>Get Classes</button> */}

            <select onChange={e=>{setC(e.target.value)}}>
            {                    
                classList.map((l) =>{
                return (
                    <option value={l}>{l}</option>
                    )
                })
            }
            </select>
                <button className="button-show" onClick={showScheduleByClass}>Show By Class</button>
                <br/><br/>

                <br />
            Select Teacher : 
            {/* <button onClick={getClasses}>Get Classes</button> */}

            <select onChange={e=>{setTeacher(e.target.value)}}>
                <option value={""}>None</option>
            {                    
                teacherList.map((t) =>{
                return (
                    <option value={t.teacherId}>{t.teacherId}-{t.teacherName}</option>
                    )
                })
            }
            </select>
                <button className="button-show" onClick={showScheduleByTeacher} >Show By Teacher</button>
                <br/><br/>
            <table class="table">
                <thead className="tableHead">
                    <tr>
                        <th>Class</th>
                        <th>Subject Name</th>
                        <th>Teacher Name</th>
                        <th>Start Time</th>
                        <th>End Time</th>
                        <th> </th>
                    </tr>
                </thead>
                <tbody>
                        {                    
                            scheduleList.map((sl) =>{
                            return (
                                    <ScheduleRow s={sl} />
                                )
                            })
                        }
                </tbody>
            </table>
        </div>
    )
}
export default ViewSchedule