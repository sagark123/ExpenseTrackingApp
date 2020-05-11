import React, { Component } from 'react'; 
import {Route, BrowserRouter as Router,Switch} from 'react-router-dom';
import Category from '../src/Category';
import Home from '../src/Home';
import Expenses from '../src/Expenses';

class App extends Component {
  state = {  }
  render() { 
    return ( 
      <Router>
        <Switch>
          <Route path="/" exact={true} component={Home}/>
          <Route path="/categories" exact={true} component={Category}/>
          <Route path="/expenses" exact={true} component={Expenses}/>
        </Switch>
      </Router>

     );
  }
}
 
export default App;