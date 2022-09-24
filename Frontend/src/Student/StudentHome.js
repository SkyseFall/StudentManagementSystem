import { Route, Switch, useHistory, useLocation } from "react-router";
import { BrowserRouter, Link } from "react-router-dom";
// import ViewRanks from "../Admin/Components/ViewRanks";
import MyProfile from "../Pages/Profiles/MyProfile";
import StudentProfile from "../Pages/Profiles/StudentProfile";
import PayFees from "./Components/PayFees";
import SubmitFeedback from "./Components/SubmitFeedback";
import FeedbackRow from "./Components/SubComponents/FeedbackRow";
import UploadAssignment from "./Components/SubComponents/TeacherAssignmentUploades"
import ViewMarksheet from "./Components/ViewMarksheet";
import ViewMarksOfStudents from "./Components/ViewMarksOfStudents";
import ViewScheduleOfStudent from "./Components/ViewScheduleOfStudent";
import ViewStudentAttendance from "./Components/ViewStudentAttendance";
import '../Admin/adminHome.css'
import ViewAssignments from "./Components/ViewAssignments";
import UploadSolution from "./Components/UploadSolution";

import ErrorPageMsg from "../ErrorPageMsg";

const StudentHome = () => {

    const location = useLocation()
    const user = location.state
    const histroy = useHistory();
    const Logout = () => {
        histroy.push('/Login')
    }
    return (

        <div>
            <BrowserRouter>

                <nav className="navbar navbar-expand-lg navbar-light bg-dark">
                    <div className="container-fluid">

                        <div className="collapse navbar-collapse" id="navbarNav">
                            <ul className="navbar-nav">

                                <li>
                                    <Link className="nav-link adminHome" to={{
                                        pathname: '/profile',
                                        aboutProps: {
                                            id: { user }
                                        }
                                    }

                                    }>My Profile</Link>
                                </li>
                                <li>
                                    <Link className="nav-link adminHome" to={{
                                        pathname: '/viewScheduleOfStudent',
                                        aboutProps: {
                                            id: { user }
                                        }
                                    }
                                    }>View Schedule</Link>
                                </li>

                                {/* <li>
                                    <Link className="nav-link adminHome" to={{
                                        pathname: '/submitFeedback',
                                        aboutProps: {
                                            id: { user }
                                        }
                                    }
                                    }>Submit Feedback</Link>
                                </li> */}

                                {/* <li>
                                    <Link className="nav-link adminHome" to={{
                                        pathname: '/addFeedback',
                                        aboutProps: {
                                            id: { user }
                                        }
                                    }
                                    }>Add Feedback</Link>
                                </li> */}

                                <li>
                                    <Link className="nav-link adminHome" to={{
                                        pathname: '/payFees',
                                        aboutProps: {
                                            id: { user }
                                        }
                                    }
                                    }>Pay Fees</Link>
                                </li>
                                <li>
                                    <Link className="nav-link adminHome" to={{
                                        pathname: '/ViewMarksOfStudent',
                                        aboutProps: {
                                            id: { user }
                                        }
                                    }
                                    }>View Marks</Link>
                                </li>
                                <li>
                                    <Link className="nav-link adminHome" to={{
                                        pathname: '/ViewMarksheet',
                                        aboutProps: {
                                            id: { user }
                                        }
                                    }
                                    }>View Marksheet</Link>
                                </li>
                                {/* <li>
                                    <Link className="nav-link adminHome" to="/ViewRanks">View Ranks</Link>
                                </li> */}
                                <li>
                                    <Link className="nav-link adminHome" to={{
                                        pathname: '/viewAttendance',
                                        aboutProps: {
                                            id: { user }
                                        }
                                    }
                                    }>View Attendance</Link>
                                </li>
                                <li>
                                    <Link className="nav-link adminHome" to={{
                                        pathname: '/viewAssignmentTeacher',
                                        aboutProps: {
                                            id: { user }
                                        }
                                    }
                                    }>View Assignments</Link>
                                </li>

                                <li className=" navbutton">
                                    <a className="adminHome" href="/home">Logout</a>
                                </li>

                                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                                
                                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                                &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;

                                <li className=" navbutton">
                                    <a className="adminHome">STUDENT</a>
                                </li>

                            </ul>

                        </div>
                    </div>
                </nav>
                <Switch>
                    <Route path='/profile' component={MyProfile} />
                    <Route path='/studentProfile' component={StudentProfile} />
                    <Route path='/viewScheduleOfStudent' component={ViewScheduleOfStudent} />
                    <Route path='/submitFeedback' component={SubmitFeedback} />
                    <Route path='/addFeedback' component={FeedbackRow} />
                    <Route path="/payFees" component={PayFees} />
                    <Route path="/ViewMarksOfStudent" component={ViewMarksOfStudents} />
                    <Route path="/ViewMarksheet" component={ViewMarksheet} />
                    {/* <Route path="/ViewRanks" component={ViewRanks} /> */}
                    <Route path="/viewAttendance" component={ViewStudentAttendance} />
                    <Route path="/uploadAssignment" component={UploadAssignment} />
                    <Route path="/viewAssignmentTeacher" component={ViewAssignments} />
                    <Route path="/uploadSolution" component={UploadSolution} />

                    <Route path="/errorPageMsg" component={ErrorPageMsg} />
                </Switch>
            </BrowserRouter>
        </div>
    )
}

export default StudentHome;