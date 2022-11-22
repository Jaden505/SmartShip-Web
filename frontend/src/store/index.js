<<<<<<< HEAD
import { createStore } from 'vuex';

import { auth } from './auth.module';
=======
import { createStore } from "vuex";
import { auth } from "./auth.module";
>>>>>>> 95658ca2a82f7f420896e3a002eda3042a8c91f7

const store = createStore({
    modules: {
        auth,
    },
});

export default store;