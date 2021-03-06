package com.jraska.github.client.users.ui

import android.view.View
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.SimpleEpoxyAdapter
import com.jraska.github.client.users.R
import com.jraska.github.client.users.model.RepoHeader
import kotlinx.android.synthetic.main.item_repos_section.view.repos_repeater
import kotlinx.android.synthetic.main.item_repos_section.view.repos_title

internal class ReposSectionModel(
  private val title: String,
  private val repos: List<RepoHeader>,
  private val repoListener: (RepoHeader) -> Unit
) : EpoxyModel<View>() {

  override fun getDefaultLayout(): Int {
    return R.layout.item_repos_section
  }

  override fun bind(itemView: View) {
    itemView.repos_title.text = title

    val adapter = SimpleEpoxyAdapter()
    adapter.addModels(repos.map { repo -> RepoHeaderModel(repo, repoListener) })

    itemView.repos_repeater.setAdapter(adapter)
  }
}
