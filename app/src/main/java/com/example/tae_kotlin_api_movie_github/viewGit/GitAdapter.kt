package com.example.tae_kotlin_api_movie_github.viewGit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tae_kotlin_api_movie_github.R
import com.example.tae_kotlin_api_movie_github.modelGit.RepoModel
import com.example.tae_kotlin_api_movie_github.modelMovie.Results
import com.example.tae_kotlin_api_movie_github.viewMovie.OnMovieClickListener
import kotlinx.android.synthetic.main.cardviewlayout.view.*
import kotlinx.android.synthetic.main.git_main_layout.view.*
import kotlinx.android.synthetic.main.row.view.*


//in the adapter you have a constructor
class GitAdapter(private val repoModel: List<RepoModel>) :
    RecyclerView.Adapter<GitViewHolder>() {
    override fun onBindViewHolder(holder: GitViewHolder, position: Int) {
            holder.title.text = repoModel[position].commits_url
//            holder.rv_data_display_git = repoModel[position].id.toString()
            }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitViewHolder {
        //not return right away
//        val view = MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.row,parent,false))
        // returning right away 2nd way to do
        return GitViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.cardviewlayout, parent, false)
        )

    }

    override fun getItemCount(): Int {
        return repoModel.size
    }

//        override fun onBindViewHolder(holder: GitViewHolder, position: String) {

//            //creating the binder, after the [position]. <this is where you get the option for ya list requests
//            holder. = repoModel.archive_url
//            //for the image, declare the image in the viewHolder
////        Picasso.get().load("https://image.tmdb.org/t/p/w185" + moviePopular.results[position].poster_path).into(holder.image)
////            Picasso.get().load(Constants.IMG_MOVIE + repoModel.results[position].poster_path).into(holder.image);
//            //holder for the onClickListener
//            holder.bind(repoModel.archive_url,listener)
}

//we are extending the viewHolder, it can be outside or inside the class
//outside
class GitViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//   val res = response.body()
//    Log.d("DISPLAYGITINFOR", res!!.[position])
    //this is where you load your data to the TextView in XML

//    val id = view.id

//    val title = view.tv_title_git
    val title = view.tv_cv_title
//    val cardView = view.tv_cv_title
//    val rv_data_display_git = view.cv_displayCard




}
/*
//either create your on clickListenen interface here or create a new interface in view model
interface onGitClickListener {
    fun onGitClickListener(result: Results)
    //next step go to the top in the main class and add private val listener: onMovieClickListener to the parameters
    //then got to on bind
    //then alt + enter to create member
    //go to fun bind (itemView)
    //then go to main where your (res) is and pass the object (res, object...)

}*/
