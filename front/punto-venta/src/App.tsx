
import { Provider } from 'react-redux'
import { store } from '@/presentation/store/store'
import { BrowserRouter } from 'react-router'
import { AppRoutes } from '@/presentation/routes'
import './App.css'

const  App = () => {

  return (
    <>
    <Provider store={store}>
      <BrowserRouter>
        <AppRoutes />
      </BrowserRouter>
    </Provider>
    </>
  )
}

export default App
