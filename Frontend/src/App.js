import './App.css';

import Register from './Pages/Register';
import Login from './Pages/Login';
import UpdatePassword from './Pages/UpdatePassword';
import ChangePassword from './Pages/ChangePassword';
import AdminHome from './Admin/AdminHome';
import TeacherHome from './Teacher/TeacherHome';
import StudentHome from './Student/StudentHome';
import Home from './home/Home';
import { BrowserRouter, Link, Redirect, Route, Switch } from 'react-router-dom'
import "../node_modules/bootstrap/dist/css/bootstrap.min.css"
import NavRaj from './home/NavBar';



const App = () => {

  return (
    <BrowserRouter>
      <NavRaj />

      <Switch>


        <Route exact path='/' component={Home} />
        <Route exact path='/home' component={Home} />
        <Route exact path='/register' component={Register} />

        <Route exact path='/ChangePassword' component={ChangePassword} />
        <Route exact path='/UpdatePassword' component={UpdatePassword} />
        <Route exact path='/login' component={Login} />
        <Route exact path='/AdminHome' component={AdminHome} />
        <Route exact path='/TeacherHome' component={TeacherHome} />
        <Route exact path='/StudentHome' component={StudentHome} />

      </Switch>

    </BrowserRouter>

  );
}

export default App;
