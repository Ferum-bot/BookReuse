package com.github.ferum_bot.bookreuse.ui.fragment.about_application

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import androidx.core.content.ContextCompat
import com.github.ferum_bot.bookreuse.R
import com.github.ferum_bot.bookreuse.core.extensions.copyToClipboard
import com.github.ferum_bot.bookreuse.core.models.TelegramUtils
import com.github.ferum_bot.bookreuse.databinding.FragmentAboutApplicationBinding
import com.github.ferum_bot.bookreuse.ui.fragment.base.BaseFragment
import com.github.ferum_bot.bookreuse.ui.fragment.delegates.viewBinding

/**
 * Created by Matvey Popov.
 * Date: 23.02.2021
 * Time: 23:24
 * Project: BookReuse
 */
class AboutApplicationFragment: BaseFragment(R.layout.fragment_about_application) {

    private val binding by viewBinding { FragmentAboutApplicationBinding.bind(it) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureClickableTextView()
    }

    override fun onStart() {
        super.onStart()

        setAllSpannableText()
        setAllClickListeners()
    }

    private fun configureClickableTextView() {
        binding.linkToGithub.movementMethod = LinkMovementMethod.getInstance()
        binding.linkToVk.movementMethod = LinkMovementMethod.getInstance()
        binding.telegram.movementMethod = LinkMovementMethod.getInstance()
        binding.emailTextView.movementMethod = LinkMovementMethod.getInstance()
    }

    private fun setAllSpannableText() {
        setGithubClickableSpan()
        setVKClickableSpan()
        setTelegramClickableSpan()
        setEmailClickableSpan()
    }

    private fun setGithubClickableSpan() {
        val string = getString(R.string.link_to_github)
        val spannableString = SpannableString(string)

        val clickableSpan = object: ClickableSpan() {

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                setUpBaseOptionsToClickableSpan(ds)
            }

            override fun onClick(widget: View) {
                val errorMessage = getString(R.string.install_browser)
                startIntentWithCatchingExceptions(errorMessage) {
                    val link = getString(R.string.github_link)
                    val uriLink = Uri.parse(link)
                    startBrowser(uriLink)
                }
            }

        }

        spannableString.setSpan(clickableSpan, 0, spannableString.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.linkToGithub.text = spannableString
    }

    private fun setVKClickableSpan() {
        val string = getString(R.string.link_to_developer_vk)
        val spannableString = SpannableString(string)

        val clickableSpan = object: ClickableSpan() {

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                setUpBaseOptionsToClickableSpan(ds)
            }

            override fun onClick(widget: View) {
                val errorMessage = getString(R.string.install_browser)
                startIntentWithCatchingExceptions(errorMessage) {
                    val link = getString(R.string.vk_link)
                    val uriLink = Uri.parse(link)
                    startBrowser(uriLink)
                }
            }

        }

        spannableString.setSpan(clickableSpan, 0, spannableString.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.linkToVk.text = spannableString
    }

    private fun setTelegramClickableSpan() {
        val string = getString(R.string.telegram).removeRange(0, 1)
        val spannableString = SpannableString(string)

        val clickableSpan = object: ClickableSpan() {

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                setUpBaseOptionsToClickableSpan(ds)
            }

            override fun onClick(widget: View) {
                val errorMessage = getString(R.string.install_browser)
                startIntentWithCatchingExceptions(errorMessage) {
                    val uriLink = TelegramUtils.getBrowserLinkToUser(string)
                    startBrowser(uriLink)
                }
            }

        }

        spannableString.setSpan(clickableSpan, 0, spannableString.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.telegram.text = spannableString
    }

    private fun setEmailClickableSpan() {
        val string = getString(R.string.mandscompanyoffers_gmail_com)
        val spannableString = SpannableString(string)

        val clickableSpan = object: ClickableSpan() {

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                setUpBaseOptionsToClickableSpan(ds)
            }

            override fun onClick(widget: View) {
                startIntentWithCatchingExceptions {
                    startEmailClient(string)
                }
            }

        }

        spannableString.setSpan(clickableSpan, 0, spannableString.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.emailTextView.text = spannableString
    }

    private fun setAllClickListeners() {
        binding.copyLinkToBufferVk.setOnClickListener {
            val string = getString(R.string.vk_link)
            string.copyToClipboard(requireContext())
            showSuccessfulMessage(R.string.successfully_copied_to_clipboard)
        }

        binding.copyLinkToBufferGithub.setOnClickListener {
            val string = getString(R.string.github_link)
            string.copyToClipboard(requireContext())
            showSuccessfulMessage(R.string.successfully_copied_to_clipboard)
        }

        binding.copyLinkToBufferTelegram.setOnClickListener {
            val string = getString(R.string.telegram).removeRange(0, 1)
            string.copyToClipboard(requireContext())
            showSuccessfulMessage(R.string.successfully_copied_to_clipboard)
        }

        binding.copyLinkToBufferEmail.setOnClickListener {
            val string = getString(R.string.mandscompanyoffers_gmail_com)
            string.copyToClipboard(requireContext())
            showSuccessfulMessage(R.string.successfully_copied_to_clipboard)
        }
    }

    private fun setUpBaseOptionsToClickableSpan(ds: TextPaint) {
        ds.underlineColor = ContextCompat.getColor(requireContext(), R.color.base_white)
        ds.linkColor = ContextCompat.getColor(requireContext(), R.color.base_white)
        ds.color = ContextCompat.getColor(requireContext(), R.color.base_white)
    }

    private fun startBrowser(uriLink: Uri) {
        val intent = Intent(Intent.ACTION_VIEW, uriLink).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        startActivity(intent)
    }

    private fun startEmailClient(email: String) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            putExtra(Intent.EXTRA_EMAIL, email)
            type = "message/rfc822"
        }
        startActivity(intent)
    }

}