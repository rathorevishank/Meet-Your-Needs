//It is used for loading and hiding,process of alert
import { createSlice } from "@reduxjs/toolkit";
export const userSlice = createSlice({
    name: "user",
    initialState: {
        user: null,
        
    },
    reducers: {
        setUser: (state, action) => {
            state.user = action.payload;
        }
       
    },
});

export const {setUser} = userSlice.actions;